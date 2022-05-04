import pymysql
import requests
from bs4 import BeautifulSoup

conn = pymysql.connect(host='localhost',
                       user='root',
                       password='rnrmfwlrdnjswjdwogns12!@',
                       db='capstone',
                       charset='utf8')

sql = "select id from patent2021_03 where key_id=%s"
sqlupdate = "update patent2021_03 set cited_by=%s, cited_by_family=%s, citation=%s where key_id=%s;"
data = []

with conn:
    with conn.cursor() as cur:
        for i in range(1, 363830):
            print(i, "/ 363829")
            cur.execute(sql, (i))
            result = cur.fetchone()
            patent_num = result[0]
            url = 'https://patents.google.com/patent/US'+patent_num+'/en?oq='+patent_num

            response = requests.get(url)

            if response.status_code == 200:
                html = response.text
                soup = BeautifulSoup(html, 'html.parser')
                h3s = soup.find_all("h2")
                citedcount = 0
                cited = 0
                familycitecount = 0
                family = 0
                citationcount = 0
                citation = 0
                for h3 in h3s:
                    h3text = h3.text
                    if citedcount == 0 and "Cited By" in h3text:
                        citedcount += 1
                        try:
                            cited = int(h3text[10:-1])
                        except:
                            print("error not int")
                    elif familycitecount == 0 and "Families Citing this family" in h3text:
                        familycitecount += 1
                        try:
                            family = int(h3text[29:-1])
                        except:
                            print("error not int")
                    elif citationcount == 0 and "Citations" in h3text:
                        citationcount += 1
                        try:
                            citation = int(h3text[11:-1])
                        except:
                            print("error not int")
                cur.execute(sqlupdate, (cited, family, citation, i))
                data.append([cited, family, citation, i])
                if i % 10000 == 0:
                    cur.executemany(sqlupdate, data)
                    conn.commit()
                    data = []

            else:
                print(response.status_code)
        cur.executemany(sqlupdate, data)
        conn.commit()

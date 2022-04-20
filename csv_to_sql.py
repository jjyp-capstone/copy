from numpy import append
import pandas as pd
import pymysql
from sqlalchemy import create_engine

db = pymysql.connect(user = 'root', host = '127.0.0.1', password = '', port = 3306, db = 'capstone')
cursor = db.cursor()

df = pd.read_csv('final.csv',encoding = 'utf-8-sig')
df.columns = ['keyword', 'weight', 'cluster']

engine = create_engine("mysql+pymysql://root:"+""+"@127.0.0.1:3306/capstone", encoding = "utf-8")
conn = engine.connect()
df.to_sql(name = "dongjun", con = engine, index = False)
conn.close()
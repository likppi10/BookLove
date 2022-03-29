import uvicorn
from fastapi import FastAPI
from routes import data

app = FastAPI()
app.include_router(data.router)

if __name__ == "__main__":
    uvicorn.run("main:app", host="0.0.0.0", port=8000, reload=True)
from flask import Flask

app = Flask(__name__)

@app.route('/')
def hello_world():
   return '{"greetings":"Hello World"}'
   
@app.route('/', defaults={'path': ''})
@app.route('/<path:path>')
def catch_all(path):
    return '{"your path":"You want path %s"}' % path

if __name__ == '__main__':
   app.run()
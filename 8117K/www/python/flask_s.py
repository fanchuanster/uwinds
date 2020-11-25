from flask import Flask
from flask import request
import requests
import logging

app = Flask(__name__)

app.logger.setLevel(logging.INFO)
app.logger.info("some text")

google_api = 'https://maps.googleapis.com'
autocomplete_path = '/maps/api/place/autocomplete/json'

@app.route(autocomplete_path)
def autocomplete():
	app.logger.info('autocomplete')
	input = request.args.get('input')
	key = request.args.get('key')
	sessiontoken = request.args.get('sessiontoken')
	redirect_url = google_api + autocomplete_path + "?input=%s&key=%s&sessiontoken=%s" % (input, key, sessiontoken)
	x = requests.get(redirect_url)

	app.logger.info(x)
	return '{"input":"%s", "key":"%s", "sessiontoken":"%s"}' % (input, key, sessiontoken)
   
# @app.route('/', defaults={'path': ''})
# @app.route('/<path:path>')
# def catch_all(path):
    # return '{"your path":"You want path %s"}' % path

if __name__ == '__main__':
   app.run()
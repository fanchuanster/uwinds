from flask import Flask
from flask import request
import requests
import logging

app = Flask(__name__)

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s', filename="apidemo.log")

app.logger.setLevel(logging.INFO)
app.logger.info("some text")

google_api = 'https://maps.googleapis.com'

autocomplete_path = '/maps/api/place/autocomplete/json'
placedetails_path = '/maps/api/place/details/json'
timezone_path = '/maps/api/timezone/json'

@app.route(timezone_path)
def timezone():
	app.logger.info('timezone')
	location = request.args.get('location')
	timestamp = request.args.get('timestamp')
	key = request.args.get('key')
	sessiontoken = request.args.get('sessiontoken')
	redirect_url = google_api + timezone_path + "?location=%s&timestamp=%s&key=%s&sessiontoken=%s" % (location, timestamp, key, sessiontoken)
	x = requests.get(redirect_url)

	app.logger.info(x.json())
	return x.json()

@app.route(placedetails_path)
def placedetails():
	app.logger.info('placedetails')
	place_id = request.args.get('place_id')
	fields = request.args.get('fields')
	key = request.args.get('key')
	sessiontoken = request.args.get('sessiontoken')
	redirect_url = google_api + placedetails_path + "?place_id=%s&fields=%s&key=%s&sessiontoken=%s" % (place_id, fields, key, sessiontoken)
	x = requests.get(redirect_url)

	# app.logger.info(x.json())
	return x.json()['result']

@app.route(autocomplete_path)
def autocomplete():
	app.logger.info('autocomplete')
	input = request.args.get('input')
	key = request.args.get('key')
	sessiontoken = request.args.get('sessiontoken')
	redirect_url = google_api + autocomplete_path + "?input=%s&key=%s&sessiontoken=%s" % (input, key, sessiontoken)
	x = requests.get(redirect_url)

	# app.logger.info(x.json())
	return x.json()
   
# @app.route('/', defaults={'path': ''})
# @app.route('/<path:path>')
# def catch_all(path):
    # return '{"your path":"You want path %s"}' % path

if __name__ == '__main__':
   app.run()
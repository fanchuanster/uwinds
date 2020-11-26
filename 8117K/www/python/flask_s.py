from flask import Flask
from flask_cors import CORS
from flask import request
import requests
import logging

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s', filename="apidemo.log")

app = Flask(__name__)
CORS(app)

app.logger.setLevel(logging.INFO)
app.logger.info("some text")

google_api = 'https://maps.googleapis.com'

autocomplete_path = '/maps/api/place/autocomplete/json'
placedetails_path = '/maps/api/place/details/json'
timezone_path = '/maps/api/timezone/json'

@app.route(timezone_path)
def timezone():
	location = request.args.get('location')
	app.logger.info('get timezone for location {} ..'.format(location))
	timestamp = request.args.get('timestamp')
	key = request.args.get('key')
	sessiontoken = request.args.get('sessiontoken')
	redirect_url = google_api + timezone_path + "?location=%s&timestamp=%s&key=%s&sessiontoken=%s" % (location, timestamp, key, sessiontoken)
	x = requests.get(redirect_url)

	app.logger.info(x.json())
	app.logger.info('get timezone for location done')
	return x.json()

@app.route(placedetails_path)
def placedetails():
	place_id = request.args.get('place_id')
	app.logger.info('get placedetails for place_id "%s"' % place_id)
	fields = request.args.get('fields')
	key = request.args.get('key')
	sessiontoken = request.args.get('sessiontoken')
	redirect_url = google_api + placedetails_path + "?place_id=%s&fields=%s&key=%s&sessiontoken=%s" % (place_id, fields, key, sessiontoken)
	x = requests.get(redirect_url)

	app.logger.info(x.json())
	app.logger.info('get placedetails done')
	return x.json()['result']

@app.route(autocomplete_path)
def autocomplete():
	input = request.args.get('input')
	app.logger.info('autocomplete - getting predictions for city input "%s"..' % input)
	
	key = request.args.get('key')
	sessiontoken = request.args.get('sessiontoken')
	redirect_url = google_api + autocomplete_path + "?input=%s&key=%s&sessiontoken=%s" % (input, key, sessiontoken)
	x = requests.get(redirect_url)
	app.logger.info(str(x.content))
	app.logger.info('autocomplete - done')
	return x.json()

@app.route('/hello')
def hello_world():
    return 'Hello, World!'
   
# @app.route('/', defaults={'path': ''})
# @app.route('/<path:path>')
# def catch_all(path):
    # return '{"your path":"You want path %s"}' % path

if __name__ == '__main__':
	app.run(host= '169.48.25.194')
	# app.run()
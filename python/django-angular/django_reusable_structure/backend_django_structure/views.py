from django.shortcuts import render
from django.http import HttpResponse
import json

# Create your views here.
def auth(request):
	response_data = {}  
	response_data['userName'] = 'Adrian'
	response_data['access_token'] = 'abcdefghijklmnopqrstuvwxyz'
	return HttpResponse(json.dumps(response_data), content_type="application/json")
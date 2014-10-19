from django.shortcuts import render

# Create your views here.
def index(request):
	return render(request, 'angularjs_structure/index.html')
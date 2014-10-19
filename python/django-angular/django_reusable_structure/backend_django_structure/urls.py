from django.conf.urls import patterns,include,url
from backend_django_structure import views

urlpatterns = patterns('',
		url(r'^auth$',views.auth,name='auth'),
	)
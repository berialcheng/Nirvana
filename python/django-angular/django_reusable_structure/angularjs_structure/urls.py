from django.conf.urls import patterns,include,url
from angularjs_structure import views

urlpatterns = patterns('',
		url(r'^$',views.index,name='index'),
	)
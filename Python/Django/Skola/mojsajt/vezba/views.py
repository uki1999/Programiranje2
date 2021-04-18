from django.shortcuts import render
from django.http import HttpResponse
from .models import Vezbe
from django.views import View
# Create your views here.
def index(request):
    return HttpResponse("Prva stranica!")
def index2(request):
    return HttpResponse("Prva stranica2!")
  
from django.db import models

# Create your models here.

class Vezbe(models.Model):
    adresa = models.CharField(max_length=120)
    stranica = models.CharField(max_length=200)
    
class Vezba(models.Model):
    adresa2 = models.CharField(max_length=120)
    stranica2 = models.CharField(max_length=200)


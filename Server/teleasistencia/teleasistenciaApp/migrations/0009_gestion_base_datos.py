# Generated by Django 3.2.3 on 2022-05-05 09:30

from django.db import migrations, models
import django.utils.timezone


class Migration(migrations.Migration):

    dependencies = [
        ('teleasistenciaApp', '0008_relacion_usuario_centro'),
    ]

    operations = [
        migrations.CreateModel(
            name='Gestion_Base_Datos',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('ubicacion_copia', models.CharField(default='teleasistencia/Server/teleasistencia', max_length=200)),
                ('fecha_copia', models.DateField(default=django.utils.timezone.now)),
            ],
        ),
    ]
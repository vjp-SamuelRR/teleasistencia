# Generated by Django 3.2.3 on 2022-05-26 19:14

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('teleasistenciaApp', '0012_auto_20220523_1442'),
    ]

    operations = [
        migrations.AlterField(
            model_name='historico_agenda_llamadas',
            name='id_agenda',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.SET_NULL, related_name='historico_agenda', to='teleasistenciaApp.agenda'),
        ),
    ]

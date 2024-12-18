<?php

use yii\helpers\Html;
use yii\widgets\DetailView;

/** @var yii\web\View $this */
/** @var common\models\User $model */

$this->title = $model->username;
$this->params['breadcrumbs'][] = ['label' => 'Users', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
\yii\web\YiiAsset::register($this);
?>
<div class="user-view">

    <h1><?= Html::encode($this->title) ?></h1>

    <p>
        <?= Html::a('Update', ['update', 'id' => $model->id], ['class' => 'btn btn-primary']) ?>
        <?= Html::a('Delete', ['delete', 'id' => $model->id], [
            'class' => 'btn btn-danger',
            'data' => [
                'confirm' => 'Are you sure you want to delete this item?',
                'method' => 'post',
            ],
        ]) ?>
    </p>

    <?= DetailView::widget([
        'model' => $model,
        'attributes' => [
            'id',
            'username',
            [
              'attribute' => 'profile.nome',
              'label' => 'Nome',
            ],
            'email:email',
            [
              'attribute' => 'profile.nif',
              'label' => 'NIF',
            ],
            [
              'attribute' => 'profile.dtaNascimento',
              'label' => 'Data de Nascimento',
            ],
            [
              'attribute' => 'profile.genero',
              'label' => 'Género',
            ],
            [
              'attribute' => 'profile.telemovel',
              'label' => 'Telemóvel',
            ],
            [
              'attribute' => 'profile.morada',
              'label' => 'Morada',
            ],
            'auth_key',
            'password_hash',
            'password_reset_token',
            'role',
            'created_at:date',
            'updated_at:date',
            'verification_token',
        ],
    ]) ?>

</div>

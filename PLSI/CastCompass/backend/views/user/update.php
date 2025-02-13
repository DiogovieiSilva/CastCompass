<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;

/** @var yii\web\View $this */
/** @var common\models\User $model */

$this->title = 'Editar: ' . $user->username;
$this->params['breadcrumbs'][] = ['label' => 'Users', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $user->username, 'url' => ['view', 'id' => $user->id]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="user-update">

    <h1><?= Html::encode($this->title) ?></h1>


<?php $form = ActiveForm::begin(); ?>

    <?= $form->field($user, 'username')->textInput() ?>

    <?= $form->field($user, 'nome')->textInput() ?>

    <?= $form->field($user, 'morada')->textInput() ?>

    <?= $form->field($user, 'telemovel')->textInput() ?>

    <?= $form->field($user, 'email')->textInput() ?>

  <?= $form->field($user, 'role')->dropDownList(\yii\helpers\ArrayHelper::map(
    Yii::$app->authManager->getRoles(), 'name', 'name'),
    ['prompt' => 'Selecione a Role']
  )

  ?>

    <?php /*= $form->field($user, 'password')->passwordInput()*/?>

    <div class="form-group">
        <?= Html::submitButton('Guardar', ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>

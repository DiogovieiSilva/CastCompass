<?php

use yii\helpers\Html;
use yii\widgets\ActiveForm;
use common\models\Categoria;
use common\models\Iva;

/** @var yii\web\View $this */
/** @var common\models\Produto $model */

$this->title = 'Update Produto: ' . $model->id;
$this->params['breadcrumbs'][] = ['label' => 'Produtos', 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->id, 'url' => ['view', 'id' => $model->id]];
$this->params['breadcrumbs'][] = 'Update';
?>
<div class="produto-update">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'nome')->textInput() ?>

    <?= $form->field($model, 'descricao')->textInput() ?>

    <?= $form->field($model, 'preco')->textInput() ?>

    <?= $form->field($model, 'stock')->textInput() ?>

    <?= $form->field($model, 'categoriaID')->dropDownList(\yii\helpers\ArrayHelper::map(
      Categoria::find()->all(), 'id', 'nome'),
      ['prompt' => 'Selecione a Categoria']
    ) ?>

    <?= $form->field($model, 'ivaID')->dropDownList(\yii\helpers\ArrayHelper::map(
      Iva::find()->all(), 'id', 'label'),
      ['prompt' => 'Selecione o IVA']
    ) ?>

    <div class="p-2">
      <h3>Imagens</h3>
      <img src='<?= $imagem->filename ?? Yii::getAlias('@notAvailable') ?>' width = "200" class="" >
    </div>

      <div class="form-group">
        <?= Html::submitButton('Save', ['class' => 'btn btn-success']) ?>
      </div>

    <?php ActiveForm::end(); ?>


</div>

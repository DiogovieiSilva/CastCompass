<?php

namespace frontend\controllers;

class CarrinhoController extends \yii\web\Controller
{
    public function actionIndex()
    {
        return $this->render('index');
    }
}

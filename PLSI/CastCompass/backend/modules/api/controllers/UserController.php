<?php

namespace backend\modules\api\controllers;

use yii\rest\ActiveController;

/**
 * Default controller for the `api` module
 */
class UserController extends ActiveController
{
    public $modelClass = 'common\models\User';

    public function actionCount()
    {
        $usersmodel = new $this->modelClass;
        $recs = $usersmodel::find()->all();
        return ['count' => count($recs)];
    }
}

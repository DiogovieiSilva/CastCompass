<?php

namespace common\models;

use Yii;

/**
 * This is the model class for table "imagem".
 *
 * @property int $id
 * @property string $filename
 *
 * @property Produto[] $produtos
 */
class Imagem extends \yii\db\ActiveRecord
{

    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'imagem';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['filename', 'produtoID'], 'required'],
            [['filename'], 'string'],
            [['filename'], 'unique'],
            [['produtoID'], 'integer'],
            [['produtoID'], 'exist', 'skipOnError' => true, 'targetClass' => Produto::class, 'targetAttribute' => ['produtoID' => 'id']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'id' => 'ID',
            'filename' => 'Filename',
            'produtoID' => 'Produto ID',
        ];
    }

    /* 
     * @brief This function return the path of the uploaded images
     * @return string
     */
    public function getPath(){
      return Yii::getAlias('@web') . 'uploads/';
    }
  
    /*
     * @brief This function return the path of the image and the filename with extension 
     *
     */  
    /* public function getPathImage() {
      return Yii::getAlias('@web') . 'uploads/' . $this->filename;
    } */

    /**
     * Gets query for [[Produtos]].
     *
     * @return \yii\db\ActiveQuery
     */
    public function getProduto()
    {
        return $this->hasOne(Produto::class, ['id' => 'produtoID']);
    }
}

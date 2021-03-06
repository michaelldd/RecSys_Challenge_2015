package org.recsys.challenge.model
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.tree.RandomForest
import org.apache.spark.rdd.RDD
//随机森林用regression的方法
class RF(data:RDD[LabeledPoint]) extends Serializable{
  def run = {
    val categoricalFeaturesInfo = Map[Int, Int]((3,16),(4,13),(5,32),(6,8))
    val numTrees = 150 // Use more in practice.
    val featureSubsetStrategy = "onethird" // Let the algorithm choose.
    val impurity = "variance"
    val maxDepth = 10
    val maxBins = 100
    RandomForest.trainRegressor(data, categoricalFeaturesInfo,
      numTrees, featureSubsetStrategy, impurity, maxDepth, maxBins)
  }
}

package in.kcrob.flinkexamples.core

import org.apache.flink.api.common.JobExecutionResult
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.scala.extensions._
/**
  * Created by kcrob.in on 13/11/17.
  */
object HelloFlink extends App {
  private val environment: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

  private val stream: DataStream[String] = environment.fromCollection(Seq("A", "B", "C"))

  stream
    .map(a => (a, a))
      .keyBy(0)
      .reduce((a, b) => (a._1 + a._2, b._1 + b._2) )
    .print()

  private val result: JobExecutionResult = environment.execute()

  print("hello")
}
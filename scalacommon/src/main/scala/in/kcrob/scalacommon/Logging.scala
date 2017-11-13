package in.kcrob.scalacommon

import org.slf4j.{Logger, LoggerFactory}

/**
  * Created by kcrob.in on 13/11/17.
  */
trait Logging {
  private val _LOG = LoggerFactory.getLogger(getClass)
  def LOG: Logger = _LOG
}

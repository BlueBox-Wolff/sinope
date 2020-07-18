package de.bluebox.wolff.sinope.protocol.packet

class InvalidPacketException : RuntimeException {
  private constructor(message: String) : super(message)
  private constructor(message: String, cause: Throwable) : super(message, cause)

  companion object {
    @JvmStatic
    fun of(message: String): InvalidPacketException {
      return InvalidPacketException(message)
    }

    @JvmStatic
    fun of(message: String, cause: Throwable): InvalidPacketException {
      return InvalidPacketException(message, cause)
    }
  }
}
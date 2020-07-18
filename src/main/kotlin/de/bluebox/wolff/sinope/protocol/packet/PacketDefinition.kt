package de.bluebox.wolff.sinope.protocol.packet

class PacketDefinition private constructor(private val packetClass: Class<out Packet>, private val id: Int) {
  fun packetClass(): Class<out Packet> {
    return packetClass
  }

  fun id(): Int {
    return id
  }

  companion object {
    @JvmStatic
    fun of(packetClass: Class<out Packet>): PacketDefinition {
      if (!packetClass.isAnnotationPresent(PacketMeta::class.java)) {
        throw InvalidPacketException.of("No PacketMeta annotation present")
      }

      val packetMeta = packetClass.getAnnotation(PacketMeta::class.java)
      val id: Int = packetMeta.id
      return PacketDefinition(packetClass, id)
    }
  }
}
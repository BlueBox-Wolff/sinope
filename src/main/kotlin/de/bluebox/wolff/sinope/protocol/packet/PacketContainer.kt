package de.bluebox.wolff.sinope.protocol.packet

import io.netty.buffer.ByteBuf

class PacketContainer private constructor(private val packet: Packet, private val definition: PacketDefinition) {
  private fun id(): Int = this.definition.id()

  fun encode(buffer: ByteBuf): ByteBuf {
    val id = id()

    // todo writing id to buffer
    this.packet.write(buffer)
    return buffer
  }

  fun decode(buffer: ByteBuf) = this.packet.read(buffer)

  companion object {
    @JvmStatic
    fun of(packet: Packet, definition: PacketDefinition): PacketContainer = PacketContainer(packet, definition)
  }
}
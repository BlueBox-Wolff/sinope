package de.bluebox.wolff.sinope.protocol.packet

import io.netty.buffer.ByteBuf

interface Packet {
  fun read(buffer: ByteBuf)
  fun write(buffer: ByteBuf)
}
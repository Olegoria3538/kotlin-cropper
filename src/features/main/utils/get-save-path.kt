package GUISamples.features.main.utils

import java.io.DataInputStream
import java.io.FileInputStream
import java.io.IOException


fun getLastSavePath(): String? {
    try {
        DataInputStream(FileInputStream("super-save.txt")).use { dos ->
            return dos.readUTF()
        }
    } catch (ex: IOException) {
        return null
    }
}
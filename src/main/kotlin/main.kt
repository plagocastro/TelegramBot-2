import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.ParseMode
import com.github.kotlintelegrambot.network.fold


fun main() {
    val bot = bot {
        token = Apykey.miToken

        dispatch {
            text {
                print("Chat ID: ")
                println(message.chat.id)
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = text)
            }

            command("Detenerse") {

                val result = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Parate porfa")

                result.fold(
                        {
                            println("Vale tranqui paro")
                        },
                        {
                            println("No fodase")
                        }
                )

            }
            command("Expulsar") {
                bot.kickChatMember(chatId = ChatId.fromId(update.message!!.chat.id), userId = ChatId.fromChannelUsername(username = ),untilDate =)
            }
        }
    }
}
import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.*
import com.github.kotlintelegrambot.entities.dice.DiceEmoji
import com.github.kotlintelegrambot.entities.polls.PollType

fun main() {
    println("- Bot Iniciado -")

    val bot = bot {

        token = Apykey.miToken

        dispatch {

            command("Ayuda") {
                val help = """
                    */saludo* | El Bicho te saluda!
                    */guapa* | Cuidado que se sonroja!
                    """.trimIndent()
                bot.sendMessage(
                        chatId = ChatId.fromId(message.chat.id),
                        text = help,
                        parseMode = ParseMode.MARKDOWN
                )
            }
            command("saludo") {

                val saludando = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Holaa bollito, te hechaba de menooos \uD83E\uDD70")
                val fotosueño = bot.sendAnimation(chatId = ChatId.fromId(update.message!!.chat.id), fileId = "https://media1.tenor.com/images/810d340cd4536755fbbdb41c80f63ddf/tenor.gif?itemid=11951627" )

            }

            command("guapa") {

                val saludando = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "AWWWWWWWW")
                val saludando2 = bot.sendPhoto(chatId = ChatId.fromId(update.message!!.chat.id),  photo = "https://cdn.discordapp.com/attachments/845056453856329729/845057433726484520/My-Hero-Academia_-Himiko-Toga-cobra-vida-gracias-a-un-increible-cosplay-2.png" )

            }
            command("QuieroDormir") {

                val sueño = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Buenas nocheees <3")
                val fotosueño = bot.sendAnimation(chatId = ChatId.fromId(update.message!!.chat.id), fileId = "http://totally-relatable.tumblr.com/page/20" )

            }


            command("TestDelBuenNovio") {

                val TestNoviazgo = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Vamos a descubrir que tan novio eres para mi!!!")

                bot.sendPoll(
                        chatId = ChatId.fromId(message.chat.id),
                        type = PollType.QUIZ,
                        question = "¿Quien es mi cantante favorito?",
                        options = listOf("Harry Styles", "Delaossa", "Maluma"),
                        correctOptionId = 1,
                        isAnonymous = true
                )

                bot.sendPoll(
                        chatId = ChatId.fromId(message.chat.id),
                        type = PollType.QUIZ,
                        question = "¿Mi comida favorita?",
                        options = listOf("Shushi", "Helado Bens&Jerrys chocolate, platano y crema de cacahuete", "McDonals"),
                        correctOptionId = 2,
                        isAnonymous = true
                )
                bot.sendPoll(
                    chatId = ChatId.fromId(message.chat.id),
                    type = PollType.QUIZ,
                    question = "¿?",
                    options = listOf("Shushi", "Helado Bens&Jerrys chocolate, platano y crema de cacahuete", "McDonals"),
                    correctOptionId = 2,
                    isAnonymous = true
                )
                bot.sendPoll(
                    chatId = ChatId.fromId(message.chat.id),
                    type = PollType.QUIZ,
                    question = "¿A donde quiero ir de vacaciones?",
                    options = listOf("San Sevantian", "Islas Sanwiches del Sur", "Hawai"),
                    correctOptionId = 2,
                    isAnonymous = true
                )

            }
            command("Juguemos") {

                val juego = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "METELA COMO MYKE!!!")
                bot.sendDice(chatId = ChatId.fromId(update.message!!.chat.id), emoji = DiceEmoji.Basketball)

            }
        }
    }
    bot.startPolling()
}


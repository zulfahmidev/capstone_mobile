package com.capstone.arahku.model.source

import com.capstone.arahku.R

object DummyDataSource {
    val menuTestList = listOf(
        MenuTest(
            "Tes Minat & Bakat",
            "Tes minat dan bakat adalah metode yang digunakan untuk membantu individu menentukan jurusan atau karier yang sesuai dengan minat dan bakat mereka. Tes ini dirancang untuk mengidentifikasi preferensi dan kecenderungan individu terhadap berbagai bidang atau jenis pekerjaan.\n "+
                    "\n"+
                    "Kombinasi hasil dari tes minat dan bakat dapat memberikan gambaran yang lebih lengkap tentang kesesuaian individu dengan berbagai bidang atau jurusan. Tes ini dapat membantu mempersempit pilihan jurusan yang memungkinkan individu untuk menjelajahi karier yang sesuai dengan minat dan bakat mereka."
            ,
            R.drawable.img_minat_bakat,
            R.drawable.img_tes_minat_bakat
        ),
        MenuTest(
            "Tes Otak Kanan & Otak Kiri",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod",
            R.drawable.img_otak_kanan_kiri,
            R.drawable.img_tes_otak_kanankiri
        ),
        MenuTest(
            "Tes Kesesuaian Jurusan",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod",
            R.drawable.img_kesesuaian_jurusan,
            R.drawable.img_tes_kesesuaian_jurusan
        )
    )


    val chatList = listOf(
        Chat(
            "Naufal Alkhalis",
            "Terimakasih Kak Naufal sudah membantu menjawab pertanyaan saya",
            "20.23",
            R.drawable.naufal,
            R.drawable.ic_verified_1
        ),
        Chat(
            "Cut Nurhidayanti",
            "Makasih Kak Yanti informasinya, semoga saya juga bisa gabung di kampus yang sama",
            "18.23",
            R.drawable.naufal,
            R.drawable.ic_verified_1
        ),
        Chat(
            "Zulfahmi",
            "Oh iya Kak, kalau di prodi ini, kira-kira nanti apa aja yang akan dipelajari ?",
            "16.23",
            R.drawable.naufal,
            R.drawable.ic_verified_1
        ),
        Chat(
            "Saiful Kamil",
            "Kalau kakak sendiri ikut organisasi apa aja kak di kampusnya ?",
            "14.23",
            R.drawable.naufal,
            R.drawable.ic_verified_2
        ),
        Chat(
            "Raidatun Anisa",
            "Di kawasan sekitar kampus kakak ada kontrakan atau kos-kosan gak kak ?",
            "12.23",
            R.drawable.naufal,
            R.drawable.ic_verified_2
        ),
        Chat(
            "Miftahul Huda",
            "Kampus kakak kan swasta dan juga dibawah naungan pondok pesantren, kira-kira ada yang membedakan gak sih kak dari kampus lainnya yang juga swasta ?",
            "09.23",
            R.drawable.naufal,
            R.drawable.ic_verified_2
        )
    )

}
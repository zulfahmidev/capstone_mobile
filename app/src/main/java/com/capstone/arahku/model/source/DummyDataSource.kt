package com.capstone.arahku.model.source

import com.capstone.arahku.R

object DummyDataSource {
    val menuTestList = listOf(
        MenuTest(
            "Tes Minat & Bakat",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod",
            R.drawable.img_minat_bakat
        ),
        MenuTest(
            "Tes Otak Kanan & Otak Kiri",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod",
            R.drawable.img_otak_kanan_kiri
        ),
        MenuTest(
            "Tes Kesesuaian Jurusan",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod",
            R.drawable.img_kesesuaian_jurusan
        )
    )

    val detailTestList = listOf(
        MenuTest(
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod",
            "1. Tidak ada jawaban yang benar maupun jawaban yang salah.\n" +
                    "2. Jawablah pertanyaan dengan apa adanya sesuai dengan diri kamu sendiri.\n" +
                    "3. Pastikan kamu berkonsentrasi.\n" +
                    "4. Test umumnya dapat dikerjakan selama 10 menit namun tidak ada batasan waktu",
            R.drawable.img_tes_minat_bakat
        ),
        MenuTest(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod",
            "1. Tidak ada jawaban yang benar maupun jawaban yang salah.\n" +
                    "2. Jawablah pertanyaan dengan apa adanya sesuai dengan diri kamu sendiri.\n" +
                    "3. Pastikan kamu berkonsentrasi.\n" +
                    "4. Test umumnya dapat dikerjakan selama 10 menit namun tidak ada batasan waktu",
            R.drawable.img_tes_otak_kanankiri
        ),
        MenuTest(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod",
            "1. Tidak ada jawaban yang benar maupun jawaban yang salah.\n" +
                    "2. Jawablah pertanyaan dengan apa adanya sesuai dengan diri kamu sendiri.\n" +
                    "3. Pastikan kamu berkonsentrasi.\n" +
                    "4. Test umumnya dapat dikerjakan selama 10 menit namun tidak ada batasan waktu",
            R.drawable.img_tes_kesesuaian_jurusan
        ),
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
            R.drawable.yanti,
            R.drawable.ic_verified_1
        ),
        Chat(
            "Zulfahmi",
            "Oh iya Kak, kalau di prodi ini, kira-kira nanti apa aja yang akan dipelajari ?",
            "16.23",
            R.drawable.fahmi,
            R.drawable.ic_verified_1
        ),
        Chat(
            "Saiful Kamil",
            "Kalau kakak sendiri ikut organisasi apa aja kak di kampusnya ?",
            "14.23",
            R.drawable.saiful,
            R.drawable.ic_verified_2
        ),
        Chat(
            "Raidatun Anisa",
            "Di kawasan sekitar kampus kakak ada kontrakan atau kos-kosan gak kak ?",
            "12.23",
            R.drawable.raida,
            R.drawable.ic_verified_2
        ),
        Chat(
            "Miftahul Huda",
            "Kampus kakak kan swasta dan juga dibawah naungan pondok pesantren, kira-kira ada yang membedakan gak sih kak dari kampus lainnya yang juga swasta ?",
            "09.23",
            R.drawable.miftah,
            R.drawable.ic_verified_2
        )
    )

}
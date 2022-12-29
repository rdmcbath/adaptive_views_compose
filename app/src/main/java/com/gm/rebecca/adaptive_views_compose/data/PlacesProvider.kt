package com.gm.rebecca.adaptive_views_compose.data

import com.google.android.gms.maps.model.LatLng

object PlacesProvider {
    val places = mutableListOf(
        Place(
            name = "Roman Colosseum",
            location = "Rome, Italy",
            description = "An oval amphitheatre begun around 70 CE during the reign of Emperor Vespasian. It is the largest ancient amphitheatre ever built, and is still the largest standing amphitheatre in the world today, despite its age.",
            latLng = LatLng(41.8874314503, 12.4886930452)
        ),
        Place(
            name = "Louvre Museum",
            location = "Paris, France",
            description = "The world's most-visited museum and historic landmark in Paris, home of some of the best-known works of art, including the Mona Lisa and the Venus de Milo.",
            latLng = LatLng(48.860294, 2.33862)
        ),
        Place(
            name = "Tikal National Park",
            location = "Northern Guatemala's Petén Province",
            description = "Tikal is a major Pre-Columbian political, economic and military center, and one of the most important archaeological complexes left by the Maya civilization.",
            latLng = LatLng(17.21714,  -89.623253)
        ),
        Place(
            name = "Petra",
            location = "Wadi Musa, Jordan",
            description = "The Rose City  is a lost archaeological city in Jordan where ancient buildings were carved into the rock walls as early as 400 BC.",
            latLng = LatLng(30.321635,  35.480125)
        ),
        Place(
            name = "Taj Mahal",
            location = "Agra, Uttar Pradesh, India",
            description = "An immense mausoleum of white marble, built in Agra in the mid 17th century, by order of the Mughal emperor Shah Jahan in memory of his favourite wife, the Taj Mahal is the jewel of Muslim art in India and one of the universally admired masterpieces of the world's heritage.",
            latLng = LatLng(27.173891,  78.042068)
        ),
        Place(
            name = "Grand Canyon",
            location = "Grand Canyon Village, Arizona, USA",
            description = "A mile-deep gorge formed 5-6 million years ago, 270 miles long and up to 18 miles wide, containing some of the oldest exposed rock on earth.",
            latLng = LatLng(36.056198,  -112.125198)
        ),
        Place(
            name = "Ryōan-ji",
            location = "Ukyo Ward, Kyoto, Japan",
            description = "Temple of the Peaceful Dragon, built in the 15th-century, with the most famous Zen rock garden. The quintessence and aesthetics of Zen is epitomized in the rock garden and architecture of Ryōanji.",
            latLng = LatLng(35.033999864, 135.717663796)
        ),
        Place(
            name = "Pyramids of Giza",
            location = "Cairo, Egypt",
            description = "The largest and most recognizable pyramid structures in the world, built to honor certain Pharaohs of the fourth ruling dynasty of Egypt during a period known as the Old Kingdom.",
            latLng = LatLng(29.976480, 31.131302)
        ),
    )

    val deletedPlaces = mutableListOf<Place>()
}
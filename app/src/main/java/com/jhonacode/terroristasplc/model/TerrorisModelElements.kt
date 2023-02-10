package com.jhonacode.terroristasplc.model


typealias TerroristModel = ArrayList<TerroristModelElement>

data class TerroristModelElement (
    val sdnType: SDNType,
    val uid: String,
    val firstName: String? = null,
    val lastName: String,
    val programList: ProgramList
)

enum class ProgramList {
    CaatsaRussia,
    CmicEo13959,
    FseIR,
    NSPLC,
    RussiaEo14024,
    RussiaEo14024SyriaUkraineEo13662,
    RussiaEo14024UkraineEo13662,
    SdgtNSPLC,
    The561Related,
    UkraineEo13662,
    UkraineEo13662RussiaEo14024,
    UkraineEo13662VenezuelaEo13850
}

enum class SDNType {
    Entity,
    Individual
}

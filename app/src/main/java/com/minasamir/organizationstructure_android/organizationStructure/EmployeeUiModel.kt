package com.minasamir.organizationstructure_android.organizationStructure

import androidx.compose.ui.graphics.Color

data class EmployeeUiModel(
    val id: String,
    val name: String,
    val color: Color = Color(0xFF2196F3),
    val position: String,
    val location: String,
    val children: List<EmployeeUiModel> = emptyList(),
    var doNotDrawDepth: MutableList<Int> = mutableListOf()
)

fun markDepthToBeNotDrawn(model: EmployeeUiModel, depth: Int) {
    if (model.children.isNotEmpty()) {
        for (child in model.children) {
            child.doNotDrawDepth.add(depth)
            markDepthToBeNotDrawn(child, depth)
        }
        return
    }
}

val simpleEmployees = listOf(
    EmployeeUiModel(
        id = "AM",
        name = "Ahmad Mohammad",
        position = "Division Head",
        location = "Sheikh Zayed St., Dubai, UAE",
        color = Color(0xFFF44336),
        children = listOf(
            EmployeeUiModel(
                id = "MM",
                name = "Mazen Mohammad",
                position = "Office Manager",
                location = "Sheikh Zayed St., Dubai, UAE",
                color = Color(0xFFFFEB3B),
                children = listOf(
                    EmployeeUiModel(
                        id = "AE",
                        name = "Ahmed El-Ahmady",
                        position = "Employee",
                        location = "Sheikh Zayed St., Dubai, UAE",
                        color = Color(0xFF9C27B0),
                        children = listOf(
                            EmployeeUiModel(
                                id = "AE",
                                name = "Mina Samir",
                                position = "Employee",
                                location = "Sheikh Zayed St., Dubai, UAE",
                                color = Color(0xFF7385F8),
                                children = listOf(
                                    EmployeeUiModel(
                                        id = "AE",
                                        name = "Mina Samir 2",
                                        position = "Employee",
                                        location = "Sheikh Zayed St., Dubai, UAE",
                                        color = Color(0xFF6F738A),
                                        children = listOf(
                                            EmployeeUiModel(
                                                id = "AE",
                                                name = "Mina Samir 4",
                                                position = "Employee",
                                                location = "Sheikh Zayed St., Dubai, UAE",
                                                color = Color(0xFF4EA2C7)
                                            ),
                                            EmployeeUiModel(
                                                id = "MA",
                                                name = "Kaylee Mina 4",
                                                position = "Employee",
                                                location = "Sheikh Zayed St., Dubai, UAE",
                                                color = Color(0xFF69C1E8)
                                            )
                                        )
                                    ),
                                    EmployeeUiModel(
                                        id = "MA",
                                        name = "Kaylee Mina 2",
                                        position = "Employee",
                                        location = "Sheikh Zayed St., Dubai, UAE",
                                        color = Color(0xFFFF00DD)
                                    )
                                )
                            ),
                            EmployeeUiModel(
                                id = "MA",
                                name = "Kaylee Mina",
                                position = "Employee",
                                location = "Sheikh Zayed St., Dubai, UAE",
                                color = Color(0xFFFF9800),
                                children = listOf(
                                    EmployeeUiModel(
                                        id = "AE",
                                        name = "Mina Samir 3",
                                        position = "Employee",
                                        location = "Sheikh Zayed St., Dubai, UAE",
                                        color = Color(0xFF040A2F)
                                    ),
                                    EmployeeUiModel(
                                        id = "MA",
                                        name = "Kaylee Mina 3",
                                        position = "Employee",
                                        location = "Sheikh Zayed St., Dubai, UAE",
                                        color = Color(0xFFE13B75)
                                    )
                                )
                            )
                        )
                    ),
                    EmployeeUiModel(
                        id = "MA",
                        name = "Mohamed Ahmed",
                        position = "Employee",
                        location = "Sheikh Zayed St., Dubai, UAE",
                        color = Color(0xFF673AB7)
                    )
                )
            ),
            EmployeeUiModel(
                id = "MM2",
                name = "Zena Amin",
                position = "Marketing Specialist",
                location = "Sheikh Zayed St., Dubai, UAE",
                color = Color(0xFF3F51B5),
                children = listOf(
                    EmployeeUiModel(
                        id = "AE",
                        name = "Mohammed Mosaad",
                        position = "Employee",
                        location = "Sheikh Zayed St., Dubai, UAE",
                        color = Color(0xFF00BCD4)
                    ),
                    EmployeeUiModel(
                        id = "MA",
                        name = "Amr Ahmed",
                        position = "Employee",
                        location = "Sheikh Zayed St., Dubai, UAE",
                        color = Color(0xFF62E564)
                    )
                )
            ),
            EmployeeUiModel(
                id = "MA",
                name = "Nora Sayed",
                position = "Employee",
                location = "Sheikh Zayed St., Dubai, UAE",
                color = Color(0xFF4CAF50),
                children = listOf(
                    EmployeeUiModel(
                        id = "AE",
                        name = "Behoy Melika",
                        position = "Employee",
                        location = "Sheikh Zayed St., Dubai, UAE",
                        color = Color(0xFF1D2E9F)
                    ),
                    EmployeeUiModel(
                        id = "MA",
                        name = "Momen Ahmed",
                        position = "Employee",
                        location = "Sheikh Zayed St., Dubai, UAE",
                        color = Color(0xFF95FF00)
                    )
                )
            )
        )
    )

)
val complexEmployees = listOf(
    EmployeeUiModel(
        id = "AM",
        name = "Ahmad Mohammad",
        position = "Division Head",
        location = "Sheikh Zayed St., Dubai, UAE",
        color = Color(0xFFF44336),
        children = listOf(
            EmployeeUiModel(
                id = "MM",
                name = "Mazen Mohammad",
                position = "Office Manager",
                location = "Sheikh Zayed St., Dubai, UAE",
                color = Color(0xFFFFEB3B),
                children = listOf(
                    EmployeeUiModel(
                        id = "AE",
                        name = "Ahmed El-Ahmady",
                        position = "Employee",
                        location = "Sheikh Zayed St., Dubai, UAE",
                        color = Color(0xFF9C27B0),
                        children = listOf(
                            EmployeeUiModel(
                                id = "AE",
                                name = "Mina Samir",
                                position = "Employee",
                                location = "Sheikh Zayed St., Dubai, UAE",
                                color = Color(0xFF7385F8),
                                children = listOf(
                                    EmployeeUiModel(
                                        id = "AE",
                                        name = "Mina Samir 2",
                                        position = "Employee",
                                        location = "Sheikh Zayed St., Dubai, UAE",
                                        color = Color(0xFF6F738A),
                                        children = listOf(
                                            EmployeeUiModel(
                                                id = "AE",
                                                name = "Mina Samir 4",
                                                position = "Employee",
                                                location = "Sheikh Zayed St., Dubai, UAE",
                                                color = Color(0xFF4EA2C7),
                                                children = listOf(
                                                    EmployeeUiModel(
                                                        id = "AE",
                                                        name = "Mina Samir 5",
                                                        position = "Employee",
                                                        location = "Sheikh Zayed St., Dubai, UAE",
                                                        color = Color(0xFF2235B0)
                                                    ),
                                                    EmployeeUiModel(
                                                        id = "MA",
                                                        name = "Kaylee Mina r",
                                                        position = "Employee",
                                                        location = "Sheikh Zayed St., Dubai, UAE",
                                                        color = Color(0xFF805515),
                                                        children = listOf(
                                                            EmployeeUiModel(
                                                                id = "AE",
                                                                name = "Mina Samir 6",
                                                                position = "Employee",
                                                                location = "Sheikh Zayed St., Dubai, UAE",
                                                                color = Color(0xFF948814),
                                                                children = listOf(
                                                                    EmployeeUiModel(
                                                                        id = "AE",
                                                                        name = "Mina Samir 7",
                                                                        position = "Employee",
                                                                        location = "Sheikh Zayed St., Dubai, UAE",
                                                                        color = Color(0xFF948814),
                                                                        children = listOf(
                                                                            EmployeeUiModel(
                                                                                id = "AE",
                                                                                name = "Mina Samir 9",
                                                                                position = "Employee",
                                                                                location = "Sheikh Zayed St., Dubai, UAE",
                                                                                color = Color(
                                                                                    0xFF948814
                                                                                )
                                                                            ),
                                                                            EmployeeUiModel(
                                                                                id = "MA",
                                                                                name = "Kaylee Mina 9",
                                                                                position = "Employee",
                                                                                location = "Sheikh Zayed St., Dubai, UAE",
                                                                                color = Color(
                                                                                    0xFFEFDA1B
                                                                                )
                                                                            )
                                                                        )
                                                                    ),
                                                                    EmployeeUiModel(
                                                                        id = "MA",
                                                                        name = "Kaylee Mina 7",
                                                                        position = "Employee",
                                                                        location = "Sheikh Zayed St., Dubai, UAE",
                                                                        color = Color(0xFFEFDA1B)
                                                                    )
                                                                )
                                                            ),
                                                            EmployeeUiModel(
                                                                id = "MA",
                                                                name = "Kaylee Mina 6",
                                                                position = "Employee",
                                                                location = "Sheikh Zayed St., Dubai, UAE",
                                                                color = Color(0xFFEFDA1B),
                                                                children = listOf(
                                                                    EmployeeUiModel(
                                                                        id = "AE",
                                                                        name = "Mina Samir 8",
                                                                        position = "Employee",
                                                                        location = "Sheikh Zayed St., Dubai, UAE",
                                                                        color = Color(0xFF948814)
                                                                    ),
                                                                    EmployeeUiModel(
                                                                        id = "MA",
                                                                        name = "Kaylee Mina 8",
                                                                        position = "Employee",
                                                                        location = "Sheikh Zayed St., Dubai, UAE",
                                                                        color = Color(0xFFEFDA1B)
                                                                    )
                                                                )
                                                            )
                                                        )
                                                    )
                                                )
                                            ),
                                            EmployeeUiModel(
                                                id = "MA",
                                                name = "Kaylee Mina 4",
                                                position = "Employee",
                                                location = "Sheikh Zayed St., Dubai, UAE",
                                                color = Color(0xFF69C1E8)
                                            )
                                        )
                                    ),
                                    EmployeeUiModel(
                                        id = "MA",
                                        name = "Kaylee Mina 2",
                                        position = "Employee",
                                        location = "Sheikh Zayed St., Dubai, UAE",
                                        color = Color(0xFFFF00DD)
                                    )
                                )
                            ),
                            EmployeeUiModel(
                                id = "MA",
                                name = "Kaylee Mina",
                                position = "Employee",
                                location = "Sheikh Zayed St., Dubai, UAE",
                                color = Color(0xFFFF9800),
                                children = listOf(
                                    EmployeeUiModel(
                                        id = "AE",
                                        name = "Mina Samir 3",
                                        position = "Employee",
                                        location = "Sheikh Zayed St., Dubai, UAE",
                                        color = Color(0xFF040A2F)
                                    ),
                                    EmployeeUiModel(
                                        id = "MA",
                                        name = "Kaylee Mina 3",
                                        position = "Employee",
                                        location = "Sheikh Zayed St., Dubai, UAE",
                                        color = Color(0xFFE13B75)
                                    )
                                )
                            )
                        )
                    ),
                    EmployeeUiModel(
                        id = "MA",
                        name = "Mohamed Ahmed",
                        position = "Employee",
                        location = "Sheikh Zayed St., Dubai, UAE",
                        color = Color(0xFF673AB7)
                    )
                )
            ),
            EmployeeUiModel(
                id = "MM2",
                name = "Zena Amin",
                position = "Marketing Specialist",
                location = "Sheikh Zayed St., Dubai, UAE",
                color = Color(0xFF3F51B5),
                children = listOf(
                    EmployeeUiModel(
                        id = "AE",
                        name = "Mohammed Mosaad",
                        position = "Employee",
                        location = "Sheikh Zayed St., Dubai, UAE",
                        color = Color(0xFF00BCD4)
                    ),
                    EmployeeUiModel(
                        id = "MA",
                        name = "Amr Ahmed",
                        position = "Employee",
                        location = "Sheikh Zayed St., Dubai, UAE",
                        color = Color(0xFF62E564)
                    )
                )
            ),
            EmployeeUiModel(
                id = "MA",
                name = "Nora Sayed",
                position = "Employee",
                location = "Sheikh Zayed St., Dubai, UAE",
                color = Color(0xFF4CAF50),
                children = listOf(
                    EmployeeUiModel(
                        id = "AE",
                        name = "Behoy Melika",
                        position = "Employee",
                        location = "Sheikh Zayed St., Dubai, UAE",
                        color = Color(0xFF1D2E9F)
                    ),
                    EmployeeUiModel(
                        id = "MA",
                        name = "Momen Ahmed",
                        position = "Employee",
                        location = "Sheikh Zayed St., Dubai, UAE",
                        color = Color(0xFF95FF00)
                    )
                )
            )
        )
    )
)

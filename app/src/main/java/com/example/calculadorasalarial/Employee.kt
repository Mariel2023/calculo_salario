package com.example.calculadorasalarial

class Employee(
    val name: String,
    val baseSalary: Double
) {

    private fun calculateRenta(): Double {
        return when {
            baseSalary <= 472.00 -> 0.0
            baseSalary <= 895.24 -> (baseSalary - 472.00) * 0.10 + 17.67
            baseSalary <= 2038.10 -> (baseSalary - 895.24) * 0.20 + 60.0
            else -> (baseSalary - 2038.10) * 0.30 + 288.57
        }
    }

    private fun calculateAFP(): Double {
        return baseSalary * 0.0725
    }

    private fun calculateISSS(): Double {
        return baseSalary * 0.03
    }

    fun calculateNetSalary(): Double {
        val renta = calculateRenta()
        val afp = calculateAFP()
        val isss = calculateISSS()
        return baseSalary - renta - afp - isss
    }

    fun getDeductionsDetail(): String {
        val renta = calculateRenta()
        val afp = calculateAFP()
        val isss = calculateISSS()
        val netSalary = calculateNetSalary()

        return """
            Nombre: $name
            Salario Base: $$baseSalary
            Renta: $$renta
            AFP (7.25%): $$afp
            ISSS (3%): $$isss
            -----------------------
            Salario Neto: $$netSalary
        """.trimIndent()
    }
}


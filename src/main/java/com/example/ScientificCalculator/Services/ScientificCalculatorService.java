package com.example.ScientificCalculator.service;

import com.example.ScientificCalculator.ComplexNumber;
import org.springframework.stereotype.Service;

@Service
public class ScientificCalculatorService {

    // Trigonometric Functions
    public double sin(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    public double cos(double angle) {
        return Math.cos(Math.toRadians(angle));
    }

    public double tan(double angle) {
        return Math.tan(Math.toRadians(angle));
    }

    // Logarithmic Functions
    public double log(double value) {
        if (value <= 0) throw new IllegalArgumentException("Logarithm is only defined for positive numbers.");
        return Math.log10(value);
    }

    public double ln(double value) {
        if (value <= 0) throw new IllegalArgumentException("Natural logarithm is only defined for positive numbers.");
        return Math.log(value);
    }

    // Exponential and Power Functions
    public double exp(double exponent) {
        return Math.exp(exponent);
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Square Root
    public double sqrt(double value) {
        if (value < 0) throw new IllegalArgumentException("Square root is not defined for negative numbers.");
        return Math.sqrt(value);
    }

    // Factorial
    public long factorial(int number) {
        if (number < 0) throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    // Complex Number Operations
    public ComplexNumber addComplex(ComplexNumber c1, ComplexNumber c2) {
        return new ComplexNumber(c1.getReal() + c2.getReal(), c1.getImaginary() + c2.getImaginary());
    }

    public ComplexNumber subtractComplex(ComplexNumber c1, ComplexNumber c2) {
        return new ComplexNumber(c1.getReal() - c2.getReal(), c1.getImaginary() - c2.getImaginary());
    }

    // Statistical Functions
    public double mean(double[] values) {
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }

    public double median(double[] values) {
        java.util.Arrays.sort(values);
        int middle = values.length / 2;
        if (values.length % 2 == 0) {
            return (values[middle - 1] + values[middle]) / 2.0;
        } else {
            return values[middle];
        }
    }

    public double standardDeviation(double[] values) {
        double mean = mean(values);
        double sum = 0.0;
        for (double value : values) {
            sum += Math.pow(value - mean, 2);
        }
        return Math.sqrt(sum / values.length);
    }
}

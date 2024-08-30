package com.example.ScientificCalculator.Controller;

import com.example.ScientificCalculator.ComplexNumber;
import com.example.ScientificCalculator.Services.CalculationHistoryService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private com.example.ScientificCalculator.service.ScientificCalculatorService calculatorService;

    @Autowired
    private CalculationHistoryService historyService;

    @GetMapping("/")
    public String showCalculator(Model model) {
        model.addAttribute("history", historyService.getAllHistory());
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam("operation") String operation,
            @RequestParam("input1") double input1,
            @RequestParam(value = "input2", required = false) Double input2,
            Model model) {

        String resultStr = "";
        String calculation = "";

        switch (operation) {
            case "sin":
                resultStr = String.valueOf(calculatorService.sin(input1));
                calculation = "sin(" + input1 + ")";
                break;
            case "cos":
                resultStr = String.valueOf(calculatorService.cos(input1));
                calculation = "cos(" + input1 + ")";
                break;
            case "tan":
                resultStr = String.valueOf(calculatorService.tan(input1));
                calculation = "tan(" + input1 + ")";
                break;
            case "sqrt":
                resultStr = String.valueOf(calculatorService.sqrt(input1));
                calculation = "sqrt(" + input1 + ")";
                break;
            case "log":
                resultStr = String.valueOf(calculatorService.log(input1));
                calculation = "log(" + input1 + ")";
                break;
            case "ln":
                resultStr = String.valueOf(calculatorService.ln(input1));
                calculation = "ln(" + input1 + ")";
                break;
            case "exp":
                resultStr = String.valueOf(calculatorService.exp(input1));
                calculation = "exp(" + input1 + ")";
                break;
            case "power":
                if (input2 != null) {
                    resultStr = String.valueOf(calculatorService.power(input1, input2));
                    calculation = "power(" + input1 + ", " + input2 + ")";
                } else {
                    resultStr = "Error: Power operation requires two inputs.";
                }
                break;
            case "factorial":
                resultStr = String.valueOf(calculatorService.factorial((int) input1));
                calculation = "factorial(" + input1 + ")";
                break;
            case "addComplex":
                if (input2 != null) {
                    ComplexNumber c1 = new ComplexNumber(input1, input2);
                    ComplexNumber c2 = new ComplexNumber(input2, input1);
                    resultStr = calculatorService.addComplex(c1, c2).toString();
                    calculation = "addComplex(" + c1 + ", " + c2 + ")";
                } else {
                    resultStr = "Error: Complex addition requires two inputs.";
                }
                break;
            case "subtractComplex":
                if (input2 != null) {
                    ComplexNumber c1 = new ComplexNumber(input1, input2);
                    ComplexNumber c2 = new ComplexNumber(input2, input1);
                    resultStr = calculatorService.subtractComplex(c1, c2).toString();
                    calculation = "subtractComplex(" + c1 + ", " + c2 + ")";
                } else {
                    resultStr = "Error: Complex subtraction requires two inputs.";
                }
                break;
            case "mean":
                resultStr = String.valueOf(calculatorService.mean(new double[]{input1, input2}));
                calculation = "mean(" + input1 + ", " + input2 + ")";
                break;
            case "median":
                resultStr = String.valueOf(calculatorService.median(new double[]{input1, input2}));
                calculation = "median(" + input1 + ", " + input2 + ")";
                break;
            case "standardDeviation":
                resultStr = String.valueOf(calculatorService.standardDeviation(new double[]{input1, input2}));
                calculation = "standardDeviation(" + input1 + ", " + input2 + ")";
                break;
            default:
                resultStr = "Error: Invalid operation.";
                break;
        }

        model.addAttribute("result", resultStr);
        model.addAttribute("history", historyService.getAllHistory());

        if (!calculation.isEmpty() && !resultStr.contains("Error")) {
            historyService.addCalculation(calculation, resultStr);
        }

        return "calculator";
    }
}

package com.guilherme.example.demo.servlets;

import java.io.IOException;

import com.guilherme.example.demo.models.Vehicle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/simulateBuy")
public class SimulationServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        double vehicleValue = Double.parseDouble(req.getParameter("VehicleValue"));

        double entryValue = Double.parseDouble(req.getParameter("EntryValue"));

        double tax = Double.parseDouble(req.getParameter("Tax"));

        int time = Integer.parseInt(req.getParameter("Time"));

        Vehicle vehicle = new Vehicle(vehicleValue, entryValue, tax, time);

        double financedValue = vehicle.getPrice() - vehicle.getEntryValue();

        double monthlyRate = vehicle.getTax() / 100;

        double monthlyPayment = financedValue *
                (monthlyRate * Math.pow(1 + monthlyRate, vehicle.getTime())) /
                (Math.pow(1 + monthlyRate, vehicle.getTime()) - 1);

        double totalPaid = monthlyPayment * vehicle.getTime();

        double totalInterest = totalPaid - financedValue;

        req.setAttribute("monthlyPayment", monthlyPayment);

        req.setAttribute("totalPaid", totalPaid);

        req.setAttribute("totalInterest", totalInterest);

        req.setAttribute("vehicle", vehicle);

        req.getRequestDispatcher("/q2/results.jsp").forward(req, resp);
    }
}
package model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface Sakujo{

	public void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
import React, { useState } from "react";
import backgroundImage from "../../assets/overview_background.jpg";
import "./LoginPage.css";

const LoginPage = () => {
  const [loginData, setLoginData] = useState({
    username: "",
    password: "",
  });

  const handleSubmit = async (e) => {
    e.preventDefault();

    const url = `http://localhost:2911/api/auth/login?username=${loginData.username}&password=${loginData.password}`;

    try {
      const response = await fetch(url, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (response.ok) {
        alert("Logged in successfully");
        window.location.href = "/";
      } else {
        alert("Failed to login");
      }
    } catch (error) {
      console.error("Failed to login", error);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setLoginData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  return (
    <div className="background_container">
      <img
        src={backgroundImage}
        alt="background"
        className="background_image"
      />
      <div className="login_box">
        <h1>Login</h1>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="username"
            placeholder="Username"
            value={loginData.username}
            onChange={handleChange}
          />
          <input
            type="password"
            name="password"
            placeholder="Password"
            value={loginData.password}
            onChange={handleChange}
          />
          <button type="submit" className="button">
            Login
          </button>
        </form>
      </div>
    </div>
  );
};

export default LoginPage;

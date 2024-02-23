import React, { useState } from "react";
import "./RegisterPage.css";
import backgroundImage from "../../assets/overview_background.jpg";
import { Link } from "react-router-dom";

const RegisterPage = () => {
  const [registerData, setRegisterData] = useState({
    username: "",
    email: "",
    fullName: "",
    password: "",
  });

  const handleSubmit = async (e) => {
    e.preventDefault();

    const url = `http://localhost:2911/api/auth/register?username=${registerData.username}&email=${registerData.email}&full_name=${registerData.fullName}&user_password=${registerData.password}`;

    try {
      const response = await fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (response.ok) {
        alert("Registered successfully");
        window.location.href = "/";
      } else {
        alert("Failed to register");
      }
    } catch (error) {
      console.error("Failed to register", error);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setRegisterData((prevData) => ({
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
      <div className="register_box">
        <h1>Register</h1>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="username"
            placeholder="Username"
            value={registerData.username}
            onChange={handleChange}
          />
          <input
            type="text"
            name="email"
            placeholder="Email"
            value={registerData.email}
            onChange={handleChange}
          />
          <input
            type="text"
            name="fullName"
            placeholder="Full Name"
            value={registerData.fullName}
            onChange={handleChange}
          />
          <input
            type="password"
            name="password"
            placeholder="Password"
            value={registerData.password}
            onChange={handleChange}
          />
          <button type="submit" className="button">
            Register
          </button>
        </form>
      </div>
    </div>
  );
};

export default RegisterPage;

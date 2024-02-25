import React from "react";
import "./OverviewPage.css";
import backgroundImage from "../../assets/overview_background.jpg";
import { Link } from "react-router-dom";

const OverviewPage = () => {
  return (
    <div className="background_container_overview">
      <img
        src={backgroundImage}
        alt="background"
        className="background_image"
      />
      <div className="welcome_box">
        <h1>
          Welcome to <br />
          TMA - Task Management Application
        </h1>
        <div className="buttons_box">
          <Link to="/login" className="button">
            Login
          </Link>
          <Link to="/register" className="button">
            Sign Up
          </Link>
        </div>
      </div>
    </div>
  );
};

export default OverviewPage;

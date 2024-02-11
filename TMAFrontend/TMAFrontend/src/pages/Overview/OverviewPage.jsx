import React from "react";
import "./OverviewPage.css";

const OverviewPage = () => {
  return (
    <div className="background_container">
      <div className="welcome_box">
        <h1>
          Welcome to <br />
          TMA - Task Management Application
        </h1>
        <div className="buttons_box">
          <button className="button">Log In</button>
          <button className="button">Sign Up</button>
        </div>
      </div>
    </div>
  );
};

export default OverviewPage;

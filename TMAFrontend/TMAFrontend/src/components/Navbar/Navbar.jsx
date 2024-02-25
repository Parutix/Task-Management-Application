import React from "react";
import profileImage from "../../assets/profile_icon.png";
import "./Navbar.css";

export default function Navbar() {
  return (
    <nav className="nav">
      <a href="/home" className="site-title">
        TMA
      </a>
      <ul>
        <li>
          <a href="/home">Home</a>
        </li>
        <li>
          <a href="/home">About</a>
        </li>
        <li>
          <a href="/home">Contact</a>
        </li>
        <li>
          <a href="/home">Profile</a>
        </li>
      </ul>
    </nav>
  );
}

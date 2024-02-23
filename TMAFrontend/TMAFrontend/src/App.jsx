import React from "react";
import "./App.css";
import OverviewPage from "./pages/Overview/OverviewPage";
import RegisterPage from "./pages/Register/RegisterPage";
import LoginPage from "./pages/Login/LoginPage";
import { createBrowserRouter, RouterProvider, Route } from "react-router-dom";

export default function App() {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <OverviewPage />,
    },
    {
      path: "/register",
      element: <RegisterPage />,
    },
    {
      path: "/login",
      element: <LoginPage />,
    },
  ]);

  return (
    <RouterProvider router={router}>
      {/* Use Route component to specify which component to render based on the URL path */}
      <Route path="/" element={<OverviewPage />} />
      <Route path="/register" element={<RegisterPage />} />
    </RouterProvider>
  );
}

import "./App.css";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Header from "./components/Header";
import Footer from "./components/Footer";
import SignUp from "./pages/Signup";
import Login from "./pages/Login";
import Horoscope from "./pages/Horo";
import Hero from "./components/Hero";
import Services from "./components/Services";
import Doshas from "./components/Doshas";
import About from "./components/About";

const Main = () => (
  <>
    <Hero />
    <Services />
    <About />
    <Doshas />
  </>
);

function App() {
  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/home" element={<Home />} />
        <Route path="/horo" element={<Horoscope />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
      </Routes>
      <Footer />
    </div>
  );
}

export default App;

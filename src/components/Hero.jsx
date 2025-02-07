import "../App.css";
import { Link } from "react-router-dom";

const Hero = () => {
  return (
    <div className="hero">
      <div className="hero-content">
        <div className="welcome-section">
          <h1>Welcome to TechSpira Astrology</h1>
          <p>Unlock the secrets of the stars and discover your destiny.</p>
          <Link to="/home" className="btn">
            Explore Your Horoscope
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Hero;

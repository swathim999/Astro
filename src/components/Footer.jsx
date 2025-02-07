import '../App.css';

const Footer = () => {
  return (
    <footer>
      <div className="footer-container">
        <div className="footer-sections">
          <div className="footer-section">
            <h3>Astrological Services</h3>
            <ul>
              <li><a href="#">Birth Chart Analysis</a></li>
              <li><a href="#">Compatibility Readings</a></li>
              <li><a href="#">Planetary Transits</a></li>
              <li><a href="#">Personal Consultations</a></li>
            </ul>
          </div>
          <div className="footer-section">
            <h3>Zodiac Insights</h3>
            <ul>
              <li><a href="#">Daily Horoscopes</a></li>
              <li><a href="#">Zodiac Compatibility</a></li>
              <li><a href="#">Planetary Guidance</a></li>
              <li><a href="#">Celestial Forecasts</a></li>
            </ul>
          </div>
          <div className="footer-section">
            <h3>Connect With Us</h3>
            <ul>
              <li><a href="#">Email: cosmic@techspira.com</a></li>
              <li><a href="#">Phone: +1 (555) STARS</a></li>
              <li><a href="#">Instagram</a></li>
              <li><a href="#">Facebook</a></li>
            </ul>
          </div>
        </div>
      </div>
      <div className="copyright">
        <p>&copy; 2024 TechSpira Astrology. Illuminating Cosmic Paths.</p>
      </div>
    </footer>
  );
};

export default Footer;
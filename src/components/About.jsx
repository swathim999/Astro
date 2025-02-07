/* eslint-disable react/no-unescaped-entities */
import "../App.css";
import Img from"../assets/img.js";
const About = () => {
  return (
    <div className="about">
      <h1>About Us</h1>
      <div className="about-content">
        <div className="about-image-container">
          <img src={Img.About} alt="About Us" className="about-img" />
        </div>
        <div className="about-text-container">
          <p>
            Our services offer a comprehensive range of astrological insights to
            guide you through life's complexities. From personalized birth chart
            readings that uncover your unique traits and potential, to
            compatibility analyses that strengthen relationships, we cater to
            every aspect of your journey. Stay updated with daily horoscopes or
            delve deeper through workshops designed to align you with universal
            rhythms. Whether you're re a seasoned astrology enthusiast seeking
            advanced insights or a beginner exploring cosmic connections, we are
            here to illuminate your path with wisdom, clarity, and guidance.
          </p>
        </div>
      </div>
    </div>
  );
};

export default About;

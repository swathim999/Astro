import { useState } from "react";
import "../App.css";
import Img from "../assets/img.js";

const Doshas = () => {
  const [activeDosha, setActiveDosha] = useState(null);

  const doshaData = [
    {
      title: "Mangal Dosha",
      image: Img.Mangal,
      cause: "Mars in specific houses (1st, 2nd, 4th, 7th, 8th, 12th).",
      effects: "Delays in marriage, conflicts.",
      remedies: "Rituals, offerings, or marrying another Manglik.",
    },
    {
      title: "Kaal Sarp Dosha",
      image: Img.Kaal,
      cause: "All seven planets trapped between Rahu and Ketu.",
      effects: "Struggles, instability in life.",
      remedies: "Special pujas for Rahu and Ketu.",
    },
    {
      title: "Chandra Dosha",
      image: Img.Chandra,
      cause:
        "Malefic influence or affliction of the Moon due to Rahu, Ketu, or Saturn.",
      effects: "Emotional instability, mental health issues.",
      remedies: "Strengthening the Moon by chanting Chandra Mantra.",
    },
    {
      title: "Shani Dosha",
      image: Img.Shani,
      cause: "Unfavorable Saturn placements or Sade Sati.",
      effects: "Struggles, obstacles, and life lessons.",
      remedies:
        "Chanting Shani Mantra, visiting temples, and performing charity.",
    },
    {
      title: "Guru Chandal Dosha",
      image: Img.Guru,
      cause: "Jupiter conjunct Rahu or Ketu.",
      effects:
        "Lack of wisdom, unethical behavior, challenges in education or career.",
      remedies: "Chanting Guru Mantra and remedies for Jupiter.",
    },
    {
      title: "Grahan Dosha",
      image: Img.Grahan,
      cause: "Sun or Moon afflicted by Rahu or Ketu.",
      effects: "Health issues, career instability, mental stress.",
      remedies: "Perform remedies during eclipses and chant planetary mantras.",
    },
    {
      title: "Rahu Dosha",
      image: Img.Rahu,
      cause: "Malefic influence of Rahu in key houses.",
      effects: "Confusion, instability, and sudden disruptions in life.",
      remedies:
        "Chant Rahu Beej Mantra, offer blue-colored items on Saturdays.",
    },
    {
      title: "Ketu Dosha",
      image: Img.Ketu,
      cause: "Malefic influence of Ketu in key houses.",
      effects: "Detachment, lack of focus, and difficulties in relationships.",
      remedies:
        "Worship Lord Ganesha, donate blankets and black sesame seeds on Tuesdays.",
    },
    // {
    //   title: "Pitra Dosha",
    //   image: "https://4.imimg.com/data4/UN/YH/MY-3939850/pitra-dosh-removal-services-500x500.jpg",
    //   cause: "Negative karmic influences from ancestors due to unfulfilled ancestral obligations or past sins.",
    //   effects: "Obstacles in career, delayed marriage, financial challenges, and recurring family problems.",
    //   remedies: "Perform Pitra Tarpan, donate food and clothes, conduct ancestor worship rituals, and visit holy sites."
    // }
  ];

  const handleDoshaClick = (index) => {
    setActiveDosha(activeDosha === index ? null : index);
  };

  return (
    <div className="doshases">
      <h1>Vedic Doshas</h1>
      <div className="doshas-grid">
        {doshaData.map((dosha, index) => (
          <div
            key={index}
            className={`dosha-card ${activeDosha === index ? "active" : ""}`}
            onClick={() => handleDoshaClick(index)}
          >
            <div className="dosha-card-inner">
              <div className="dosha-card-front">
                <img
                  src={dosha.image}
                  alt={dosha.title}
                  className="dosha-img"
                />
                <h3>{dosha.title}</h3>
              </div>
              <div className="dosha-card-back">
                <h3>{dosha.title}</h3>
                <p>
                  <strong>Cause:</strong> {dosha.cause}
                </p>
                <p>
                  <strong>Effects:</strong> {dosha.effects}
                </p>
                <p>
                  <strong>Remedies:</strong> {dosha.remedies}
                </p>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Doshas;

import { useState } from "react";
import {
  Flame,
  Earth,
  Wind,
  Sun,
  Flower,
  Heart,
  Star,
  Moon,
} from "lucide-react";
import "./Horo.css";

const zodiacSigns = [
  {
    name: "Aries",
    icon: <Flame color="#FF5733" size={30} />,
    dates: "Mar 21 - Apr 19",
    element: "Fire",
  },
  {
    name: "Taurus",
    icon: <Earth color="#4CAF50" size={30} />,
    dates: "Apr 20 - May 20",
    element: "Earth",
  },
  {
    name: "Gemini",
    icon: <Wind color="#2196F3" size={30} />,
    dates: "May 21 - Jun 20",
    element: "Air",
  },
  {
    name: "Cancer",
    icon: <Sun color="#3F51B5" size={30} />,
    dates: "Jun 21 - Jul 22",
    element: "Water",
  },
  {
    name: "Leo",
    icon: <Sun color="#FFC107" size={30} />,
    dates: "Jul 23 - Aug 22",
    element: "Fire",
  },
  {
    name: "Virgo",
    icon: <Flower color="#9C27B0" size={30} />,
    dates: "Aug 23 - Sep 22",
    element: "Earth",
  },
  {
    name: "Libra",
    icon: <Heart color="#E91E63" size={30} />,
    dates: "Sep 23 - Oct 22",
    element: "Air",
  },
  {
    name: "Scorpio",
    icon: <Star color="#673AB7" size={30} />,
    dates: "Oct 23 - Nov 21",
    element: "Water",
  },
  {
    name: "Sagittarius",
    icon: <Moon color="#795548" size={30} />,
    dates: "Nov 22 - Dec 21",
    element: "Fire",
  },
  {
    name: "Capricorn",
    icon: <Earth color="#607D8B" size={30} />,
    dates: "Dec 22 - Jan 19",
    element: "Earth",
  },
  {
    name: "Aquarius",
    icon: <Wind color="#00BCD4" size={30} />,
    dates: "Jan 20 - Feb 18",
    element: "Air",
  },
  {
    name: "Pisces",
    icon: <Flame color="#009688" size={30} />,
    dates: "Feb 19 - Mar 20",
    element: "Water",
  },
];

const dailyHoroscopes = {
  Aries: "An unexpected opportunity will arise. Stay open-minded.",
  Taurus: "Financial stability looks promising this week.",
  Gemini: "Communication will be key in resolving a personal conflict.",
  Cancer: "Emotional insights will guide you to better relationships.",
  Leo: "Your creativity is at its peak. Start that project!",
  Virgo: "Attention to detail will lead to professional success.",
  Libra: "Balance and harmony are your strengths today.",
  Scorpio: "Trust your intuition in important decisions.",
  Sagittarius: "Adventure calls. Be prepared for spontaneity.",
  Capricorn: "Disciplined approach will yield significant results.",
  Aquarius: "Innovative thinking solves complex problems.",
  Pisces: "Emotional intelligence is your superpower today.",
};

// const dailyHoroscopes = {
//   Aries:
//     "You'll Commit Suicide in Few Minutes, If you don't you'll die by Accident",
//   Taurus:
//     "Money isn't everything… which is good because you won't have any soon.",
//   Gemini: "Your Wi-Fi will betray you during an important moment.",
//   Cancer: "Your crush will send you a message… in your dreams.",
//   Leo: "You'll try to be the center of attention, but the spotlight will break.",
//   Virgo:
//     "Perfection is overrated… which is great, because you're not even close today.",
//   Libra: "You'll finally find balance… right before you fall off a chair.",
//   Scorpio: "Your mysterious vibe will confuse everyone, including yourself.",
//   Sagittarius: "Adventure is out there! But so is bad weather. Stay home.",
//   Capricorn: "Hard work pays off… but probably not for you today.",
//   Aquarius: "You'll have a brilliant idea, but no one will listen.",
//   Pisces: "Your emotional depth will scare a cat today. Congrats!",
// };

const Horoscope = () => {
  const [selectedSign, setSelectedSign] = useState(zodiacSigns[0]);

  return (
    <div className="horoscope-container">
      <div className="horoscope-layout">
        <div className="zodiac-sidebar">
          {zodiacSigns.map((sign) => (
            <div
              key={sign.name}
              className={`zodiac-item ${
                selectedSign.name === sign.name ? "active" : ""
              }`}
              onClick={() => setSelectedSign(sign)}
            >
              {sign.icon}
              <span>{sign.name}</span>
            </div>
          ))}
        </div>

        <div className="horoscope-details">
          <h1>{selectedSign.name} Horoscope</h1>
          <div className="sign-info">
            <div className="sign-icon">{selectedSign.icon}</div>
            <div className="sign-meta">
              <p>
                <strong>Dates:</strong> {selectedSign.dates}
              </p>
              <p>
                <strong>Element:</strong> {selectedSign.element}
              </p>
            </div>
          </div>
          <div className="daily-horoscope">
            <h3>Today&apos;s Insights</h3>
            <p>{dailyHoroscopes[selectedSign.name]}</p>
            <br />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Horoscope;

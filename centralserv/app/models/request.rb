class Request < ActiveRecord::Base

  belongs_to :school
  has_many :resources
  has_one :response

end